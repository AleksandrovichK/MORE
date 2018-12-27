import {ChangeDetectionStrategy, Component, ElementRef, EventEmitter, Input, OnDestroy, OnInit, Output, ViewChild} from '@angular/core';
import {animate, style, transition, trigger} from '@angular/animations';

import {fromEvent, Subject} from 'rxjs';
import {debounceTime, distinctUntilChanged, filter, pluck, takeUntil} from 'rxjs/operators';

@Component({
  selector: 'app-autocomplete',
  templateUrl: './autocomplete.component.html',
  styleUrls: ['./autocomplete.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  animations: [
    trigger('fadeIn', [
      transition(':enter', [
        style({opacity: 0}),
        animate('200ms linear', style({opacity: 1}))
      ]),

      transition(':leave', [
        style({opacity: 1}),
        animate('200ms linear', style({opacity: 0}))
      ])
    ])
  ]
})
export class AutocompleteComponent implements OnInit, OnDestroy {
  @Input()
  public loading = false;
  @Input()
  public defaultText = '';
  @Input()
  public suggestions = [];
  @Output()
  public valueChanges = new EventEmitter<string>();
  @Output()
  public selectSuggestion = new EventEmitter();
  @ViewChild('autocomplete')
  public autocomplete: ElementRef<HTMLInputElement> = null;
  private destroy$ = new Subject();

  public ngOnInit(): void {
    fromEvent<KeyboardEvent>(this.autocomplete.nativeElement, 'keyup').pipe(
      debounceTime(500),
      distinctUntilChanged(),
      pluck<KeyboardEvent, string>('target', 'value'),
      filter((value) => value.length > 2),
      takeUntil(this.destroy$)
    ).subscribe((value) => {
      this.valueChanges.emit(value);
    });
  }

  public ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  hideSuggestions() {
    this.suggestions = [];
  }
}

