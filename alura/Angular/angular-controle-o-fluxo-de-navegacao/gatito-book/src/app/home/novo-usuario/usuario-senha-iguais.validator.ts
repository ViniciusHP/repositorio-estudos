import { FormGroup } from '@angular/forms';
export function usuarioSenhaIguaisValidator(formGroup: FormGroup) {
  const username: string = formGroup.get('userName')?.value ?? '';
  const password: string = formGroup.get('password')?.value ?? '';

  if (username.trim() + password.trim()) {
    return username !== password ? null : { senhaIgualUsuario: true };
  }

  return null;
}
