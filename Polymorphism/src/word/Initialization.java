package word;

public class Initialization extends CommandImpl{


    public Initialization(StringBuilder text) {
        super(text);

    }

    public static CommandInterface buildCommandInterface(StringBuilder text){
        return new CommandImpl(text);

    }
}
