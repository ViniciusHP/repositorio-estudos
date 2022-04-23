import { ComponentFixture, TestBed } from "@angular/core/testing";
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";
import { UniqueIdService } from "../../services/unique-id/unique-id.service";
import { LikeWidgetComponent } from "./like-widget.component";

describe(LikeWidgetComponent.name, () => {
    let fixture: ComponentFixture<LikeWidgetComponent> = null;

    /* Está forma é independente do builder do projeto */
    beforeEach(async () => {
        /* Vai esperar a compilação do componente para só depois dar continuidade aos testes */
        await TestBed.configureTestingModule({
            declarations: [LikeWidgetComponent],
            imports: [FontAwesomeModule],
            providers:[UniqueIdService]
        }).compileComponents();
        /* compileComponents é assíncrono, ele vai compilar o componente,
        resolver o template do componente por meio de uma requisição assíncrona e gerar o componente */

        fixture = TestBed.createComponent(LikeWidgetComponent);
    })

    /* Se o builder for o Webpack, não é necessário fazer o processo assíncrono */
    /* beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [LikeWidgetComponent]
        })
    }) */

    it(`Should create component`, () => {
        const instance = fixture.componentInstance;
        expect(instance).toBeTruthy();
    })
})
