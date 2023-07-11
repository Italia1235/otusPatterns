package otus.homework.patterns.hw2.commands;

import otus.homework.patterns.hw2.intrf.CommandQueue;

import java.util.ArrayList;


public class LongMoveCommand extends MacroCommand{

    public LongMoveCommand(MoveCommand moveCommand, CommandQueue commandQueue){

        super( new ArrayList<>());
        commandList.add(moveCommand);
        commandList.add(new QueueAddCommand(this, commandQueue));

    }



}

