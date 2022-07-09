import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '@core/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  form: FormGroup = new FormGroup({
    username: new FormControl(null, Validators.required),
    password: new FormControl(null, Validators.required),
  });

  error: boolean = false;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {}

  login() {
    if (!this.form.valid) {
      this.error = true;
      return;
    }

    const request = this.authService.login(this.form.value);
    request.subscribe({
      next: () => {},
      error: () => {
        this.error = true;
      },
    });
  }
}
