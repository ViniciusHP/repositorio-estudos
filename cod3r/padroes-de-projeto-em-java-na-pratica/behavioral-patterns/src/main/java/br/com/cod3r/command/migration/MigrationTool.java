package br.com.cod3r.command.migration;

import br.com.cod3r.command.migration.commands.MigrationCommand;

import java.util.LinkedList;
import java.util.List;

public class MigrationTool {
    private final List<MigrationCommand> migrations;
    private int nextMigrationIndex;

    public MigrationTool() {
        this.migrations = new LinkedList<>();
        nextMigrationIndex = 0;
    }

    public void addMigration(MigrationCommand command) {
        migrations.add(command);
    }

    public void up() {
        if(nextMigrationIndex >= migrations.size()) {
            System.out.println("You are up to date!");
            return;
        }

        migrations.get(nextMigrationIndex).execute();
        nextMigrationIndex++;
    }

    public void down() {
        if(nextMigrationIndex <= 0) {
            System.out.println("You don't have migrations left");
            return;
        }

        nextMigrationIndex--;
        migrations.get(nextMigrationIndex).undo();
    }

    public void latest() {
        while (nextMigrationIndex < migrations.size()) up();
    }

    public void rollback() {
        while (nextMigrationIndex > 0) down();
    }
}
