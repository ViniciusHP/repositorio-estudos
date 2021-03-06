import { ComponentFixture, TestBed } from "@angular/core/testing";
import { LikeWidgetComponent } from "./like-widget.component";
import { LikeWidgetModule } from "./like-widget.module";

describe(LikeWidgetComponent.name, () => {
    let fixture: ComponentFixture<LikeWidgetComponent> = null;
    let component : LikeWidgetComponent = null;

    /* Está forma é independente do builder do projeto */
    beforeEach(async () => {
        /* Vai esperar a compilação do componente para só depois dar continuidade aos testes */
        await TestBed.configureTestingModule({
            imports: [LikeWidgetModule]
        }).compileComponents();
        /* compileComponents é assíncrono, ele vai compilar o componente,
        resolver o template do componente por meio de uma requisição assíncrona e gerar o componente */

        fixture = TestBed.createComponent(LikeWidgetComponent);
        component = fixture.componentInstance;
    })

    /* Se o builder for o Webpack, não é necessário fazer o processo assíncrono */
    /* beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [LikeWidgetComponent]
        })
    }) */

    it(`
    SHOULD create component`, () => {
        expect(component).toBeTruthy();
    });

    it(`
    SHOULD auto-generate ID during ngOnInit
    WHEN (@Input id) is not assigned`, () => {
        fixture.detectChanges();
        expect(component.id).toBeTruthy();
    })

    it(`
    SHOULD NOT auto-generate ID during ngOnInit
    WHEN (@Input id) is assigned`, () => {
        const someId = 'someId';
        component.id = someId;
        fixture.detectChanges();
        expect(component.id).toBe(someId);
    })

    it(`#${LikeWidgetComponent.prototype.like.name}
    SHOULD trigger (@Output liked)
    WHEN called`, () => {
        spyOn(component.liked, 'emit');
        fixture.detectChanges();
        component.like();
        expect(component.liked.emit).toHaveBeenCalled();
    });
})
