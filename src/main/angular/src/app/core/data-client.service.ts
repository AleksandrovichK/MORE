import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {environment} from './environments/environment';
import {ResponseResult} from './models/response-result';

@Injectable({
  providedIn: 'root',
})
export class DataClientService {
  baseUrl = environment.apiUrl;
  withCredentials: true;
  header = new HttpHeaders({
    'content-type': 'application/json'
  });

  constructor(private http: HttpClient) {
  }

  get<T>(url: string, params?: HttpParams): Observable<any> {
    return this.http.get<ResponseResult<T>>(this.baseUrl + url, {headers: this.header, params: params})
      .pipe(
        map(response =>
          (response? (response.success ? response.data : null): null)
        ));
  }

  post<T>(url: string, body: any = null): Observable<any> {
    return this.http.post<ResponseResult<T>>(this.baseUrl + url, body, {headers: this.header,  withCredentials: this.withCredentials})
      .pipe(
        map(response =>
          (response? (response.success ? response.data : null): null)
        ));
  }

  put<T>(url: string, body: any = null): Observable<any> {
    return this.http.put<ResponseResult<T>>(this.baseUrl + url, body, {headers: this.header})
      .pipe(
        map(response =>
          (response? (response.success ? response.data : null): null)
        ));
  }

  delete(url: string, params?: HttpParams) {
    this.http.delete(this.baseUrl + url, {headers: this.header, params: params});
  }

}
