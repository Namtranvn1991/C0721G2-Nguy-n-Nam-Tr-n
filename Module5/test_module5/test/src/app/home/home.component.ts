import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  selectFiles: FileList;
  files: File[];
  urls = new Array<string>();
  uploadUrls = new Array<string>();
  form: FormGroup = this.formBuilder.group(
    {
      id: [],
      imgUrls: [],
      note: [],
    }
  );

  constructor(private http: HttpClient, public db: AngularFireStorage, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
  }

  detectFiles(event) {
    if (this.urls.length !== 0){
      this.urls = new Array<string>();
    }
    if (event.target.files.length > 5) {
      alert('select only 5 file at a time...');
      return;
    } else {
      const files = event.target.files;
      this.selectFiles = files;
      if (files) {
        for (const file of files) {
          console.log(file);
          const reader = new FileReader();
          reader.onload = (e: any) => {
            this.urls.push(e.target.result);
          };
          reader.readAsDataURL(file);
        }
        console.log(this.urls);
      }
    }
  }


  onSubmit() {
    console.log(this.selectFiles);
    for (let i = 0; i < this.selectFiles.length; i++) {
      this.upload(i);
    }
    console.log(this.uploadUrls);
    this.form.value.imgUrls = this.uploadUrls;
    console.log(this.form);
  }

  upload(index: number): any {
    const urlPath = this.selectFiles.item(index).name + new Date().getTime();
    const fileRef = this.db.ref(urlPath);
    this.db.upload(urlPath, this.selectFiles.item(index)).snapshotChanges().pipe(
      finalize(
        () => {
          fileRef.getDownloadURL().subscribe((url) => {
            this.uploadUrls.push(url);
          });
        }
      )
    ).subscribe();
  }
}
