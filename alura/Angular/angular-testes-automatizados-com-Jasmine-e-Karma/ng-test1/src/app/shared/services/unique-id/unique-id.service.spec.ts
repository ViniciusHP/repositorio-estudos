import { UniqueIdService } from "./unique-id.service";

describe(UniqueIdService.name, () => {
    let service: UniqueIdService = null;
    
    beforeEach(() => {
        service = new UniqueIdService();
    });

    it(`#${UniqueIdService.prototype.generateUniqueIdWithPrefix.name}
    SHOULD generate id
    WHEN called with prefix`, () => {
        const id = service.generateUniqueIdWithPrefix('app');
        expect(id.startsWith('app-')).toBeTrue();
    });

    it(`#${UniqueIdService.prototype.generateUniqueIdWithPrefix.name}
    SHOULD not generate duplicate IDs
    WHEN called multiple times`, () => {
        const ids = new Set();
        for(let i = 0; i < 50; i++) {
            ids.add(service.generateUniqueIdWithPrefix('app'));
        }
        expect(ids.size).toBe(50);
    });

    it(`#${UniqueIdService.prototype.getNumberOfGeneratedUniqueIds.name}
    SHOULD return the number of generated IDs
    WHEN called`, () => {
        service.generateUniqueIdWithPrefix('app');
        service.generateUniqueIdWithPrefix('app');
        expect(service.getNumberOfGeneratedUniqueIds()).toBe(2);
    });

    it(`#${UniqueIdService.prototype.generateUniqueIdWithPrefix.name}
    SHOULD throw
    WHEN called with empty`, () => {
        const emptyValues = [null, undefined, ''];
        emptyValues.forEach(emptyValue => {
            expect(() => service.generateUniqueIdWithPrefix(emptyValue)).toThrow();
        })
    })
});
