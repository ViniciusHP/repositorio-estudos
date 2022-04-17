import { Directive, OnDestroy, OnInit } from "@angular/core";

@Directive({
    selector: '[appFocusBack]'
})
export class FocusBackDirective implements OnInit, OnDestroy {
    private lastFocusedElement: Element = null;

    public ngOnInit(): void {
        // Antes de construir os próximos componentes da view, será guardado a 
        // referência do elemento com o foco para só depois os elementos dentro do modal receberem foco
        this.lastFocusedElement = document.activeElement;    
    }

    public ngOnDestroy(): void {
        if(this.lastFocusedElement) {
            (this.lastFocusedElement as HTMLElement).focus();
        }
    }
}