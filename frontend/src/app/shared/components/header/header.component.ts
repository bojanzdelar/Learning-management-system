import { Component, Input, OnInit } from '@angular/core';
import { AuthService } from '@core/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  @Input()
  text: string;

  constructor(public authService: AuthService) {}

  ngOnInit(): void {}

  getUsername() {
    return this.authService.user.sub;
  }
}
