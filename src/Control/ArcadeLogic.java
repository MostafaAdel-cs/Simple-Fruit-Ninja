package Control;

public class ArcadeLogic {

    private static ArcadeLogic instance;

    private ArcadeLogic() {
    }
    public static ArcadeLogic createClassicLogic()
    {
        if(instance==null)
            instance=new ArcadeLogic();
        return instance;
    }
}
