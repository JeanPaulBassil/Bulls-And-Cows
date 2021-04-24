package bullscows;

public class On {
    NumberGenerator numGen = new NumberGenerator();
    Checker check = new Checker();

    public void commands() {
        numGen.mainCommands();
        check.GuessAndCheck(numGen);
    }

}
