package Model.GameObjects;

public class GameObjectFactory {

    private static GameObjectFactory instance;

    private GameObjectFactory() {

    }

    public GameObjectFactory createObjectFactory() {
        if(instance==null)
        {
            instance=new GameObjectFactory();
        }
        return instance;
    }


    public GameObject createObject(String objectType)
    {
        if(objectType.contentEquals("Apple"))
            return new Apple();
        else if(objectType.contentEquals("WaterMellon"))
            return new WaterMellon();
        else if(objectType.contentEquals("Banana"))
            return new Banana();
        else if(objectType.contentEquals("Bomb"))
            return new Bomb();
        else if(objectType.contentEquals("SpecialBomb"))
            return new SpecialBomb();

        return null;
    }
}
