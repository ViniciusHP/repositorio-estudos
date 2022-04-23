import { TestBed } from "@angular/core/testing";
import { LikeWidgetComponent } from "./like-widget.component";

describe(LikeWidgetComponent.name, () => {
    let component: LikeWidgetComponent = null;

    /* Está forma é independente do builder do projeto */
    beforeEach(async () => {
        /* Vai esperar a compilação do componente para só depois dar continuidade aos testes */
        await TestBed.configureTestingModule({
            declarations: [LikeWidgetComponent]
        }).compileComponents();
        /* compileComponents é assíncrono, ele vai compilar o componente,
        resolver o template do componente por meio de uma requisição assíncrona e gerar o componente */
    })

    /* Se o builder for o Webpack, não é necessário fazer o processo assíncrono */
    /* beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [LikeWidgetComponent]
        })
    }) */

    it(``, () => {

    })
})
