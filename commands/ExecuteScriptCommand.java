package commands;

import tools.CommandExecutor;
import tools.DataReader;

import java.io.*;

/**
 *
 * class executing the script
 */

public class ExecuteScriptCommand extends Command{

    CommandExecutor commandExecutor;
    DataReader reader;
    private byte executesCounter = 0;

    public ExecuteScriptCommand(String name, CommandExecutor commandExecutor, DataReader reader) {
        super(name);
        this.commandExecutor = commandExecutor;
        this.reader = reader;
    }


    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        if (this.executesCounter == 100) {
            System.out.println("Максимальное глубина рекурсии достигнута");
            this.executesCounter = 0;
        } else {
            this.executesCounter++;
            if (this.arguments.split(" ").length == 1) {
                System.out.println("Ошибка! Команда execute_script должна вводиться вместе с путем до скрипта через пробел");
            } else {
                commandExecutor.setInteractiveStatus(false);
                reader.setInteractive(false);
                try {
                    reader.setPath(this.arguments.split(" ")[1]);
                } catch (FileNotFoundException | UnsupportedEncodingException e) {
                    System.out.println("Ошибка доступа к файлу!");
                }
                String line = reader.readline();
                while (!line.equals("EOF")) {
                    commandExecutor.execute(line);

                    line = reader.readline();
                }
                commandExecutor.setInteractiveStatus(true);
                reader.setInteractive(true);
            }
        }

    }

    @Override
    public void getDescription() {
        System.out.println("Команда execute_script file_name исполняет построчно скрипт.");
    }
}
