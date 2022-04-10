import { ApplicationRef, ComponentRef, EmbeddedViewRef, Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class BodyInjectorService {
  constructor(private appRef: ApplicationRef){}

  public stackBeforeAppRoot(componentRef: ComponentRef<any>): void {
    const domElement = this.createDomElement(componentRef);
    const appRoot = document.body.querySelector('app-root');
    document.body.insertBefore(domElement, appRoot);
  }

  private createDomElement(componentRef: ComponentRef<any>): HTMLElement {
    this.appRef.attachView(componentRef.hostView); // Colocando a view do componente na view do Angular, fazendo o Angular gerenciar esta view
    const domElement = (componentRef.hostView as EmbeddedViewRef<any>) // Obtendo o elemento do DOM a partir dos nós
      .rootNodes[0] as HTMLElement;
    return domElement;
  }
}
