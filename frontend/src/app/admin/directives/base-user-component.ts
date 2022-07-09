import { Directive } from '@angular/core';
import { BaseComponent } from '@shared/directives/base-component';
import { Base } from '@core/models/base.model';
import { User } from '@core/models/user.model';
import { UserService } from '@core/services/user.service';

@Directive()
export abstract class BaseUserComponent<
  T extends Base
> extends BaseComponent<T> {
  constructor(public userService: UserService) {
    super();
  }

  override process(value: any) {
    const user: User = {
      username: value['user'] as string,
    };
    if (value['ids'].user) {
      user.id = value['ids'].user;
    }
    if (value['password']) {
      user['password'] = value['password'];
    }
    delete value['ids'];
    delete value['password'];
    value.user = user;

    this.userService.getIdByUsername(user.username).subscribe({
      next: (id) => {
        if (!user.id || (user.id && user.id !== id)) {
          window.alert('Username already exists! Please try again!');
          return;
        }
        super.process(value);
      },
      error: () => {
        super.process(value);
      },
    });
  }
}
