import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  selectFiles: FileList;
  files: File[];

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  fileSelected(event: Event) {
    const target = event.target as HTMLInputElement;
    this.selectFiles = target.files;
    console.log(this.selectFiles);
  }

  upload() {
    const fd = new FormData();
    for (let i = 0; i < this.selectFiles.length ; i++) {
      fd.append('img[]', this.selectFiles.item(i));
    }
    // fd.append('img', this.selectFiles.item(0));
    console.log(fd);
    this.http.post('http://localhost:8080', fd).subscribe(res => {
        console.log(res);
    });
  }
}
