import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from './environments/environment';
import {ResponseResult} from './models/response-result';

@Injectable({
  providedIn: 'root',
})
export class DataClientService {
  baseUrl = environment.apiUrl;
  header = new HttpHeaders({
    'content-type': 'application/json',
  });

  constructor(private http: HttpClient) {
  }

  get<T>(url: string, params?: HttpParams): Observable<any> {
    const res: any =  this.http.get<ResponseResult<T>>(this.baseUrl + url, {headers: this.header, params: params});
    return (res.success ? res.data : null);
  }

  post<T>(url: string, body: any = null): Observable<any> {
    const res: any = this.http.post<ResponseResult<T>>(this.baseUrl + url, body, {headers: this.header});
    return (res.success ? res.data : null);
  }

  put<T>(url: string, body: any = null): Observable<any> {
    const res: any = this.http.put<ResponseResult<T>>(this.baseUrl + url, body, {headers: this.header});
    return (res.success ? res.data : null);
  }

  delete(url: string, params?: HttpParams): Observable<any> {
    const res: any = this.http.delete(this.baseUrl + url, {headers: this.header, params: params});
    return (res.success ? res.data : null);
  }
}
