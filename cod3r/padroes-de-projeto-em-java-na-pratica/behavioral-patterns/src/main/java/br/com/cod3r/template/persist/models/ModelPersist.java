package br.com.cod3r.template.persist.models;

public abstract class ModelPersist {

    public final ModelPersist save() {
        preSave();
        prePersist();
        System.out.printf("Saving %s in database\n", this.getClass().getSimpleName());
        postSave();
        return this;
    }

    public final ModelPersist update() {
        preUpdate();
        prePersist();
        System.out.printf("Updating %s in database\n", this.getClass().getSimpleName());
        postUpdate();
        return this;
    }

    public final ModelPersist delete() {
        preDelete();
        System.out.printf("Deleting %s in databse\n", this.getClass().getSimpleName());
        postDelete();
        return this;
    }

    public void preSave() {}
    public void prePersist() {}

    public void postSave() {}
    public void preUpdate() {}
    public void postUpdate() {}
    public void preDelete() {}
    public void postDelete() {}
}
