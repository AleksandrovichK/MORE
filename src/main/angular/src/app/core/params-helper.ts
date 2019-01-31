import { HttpParams } from '@angular/common/http';

export class ParamsHelper {
  static toHttpParams(obj: Object): HttpParams {
    let httpParams = new HttpParams();
    Object.keys(obj).forEach(key => {
      const value = obj[key];
      if (value || value === 0 || value === false) {
        httpParams = httpParams.append(key, this.transformValue(value));
      }
    });
    return httpParams;
  }

  private static transformValue(value) {
    return (value instanceof Date) ? value.toISOString() : value.toString()
  }
}
