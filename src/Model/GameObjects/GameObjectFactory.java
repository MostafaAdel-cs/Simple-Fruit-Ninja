package Model.GameObjects;

public class GameObjectFactory {

    private static GameObjectFactory instance;

    public GameObjectFactory() {

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
            return new Fruit("Apple");
        else if(objectType.contentEquals("Bomb"))
            return new Bomb("Bomb");
        else if(objectType.contentEquals("TimeSpecialFruit"))
            return new SpecialFruit("TimeSpecialFruit");
        else if(objectType.contentEquals("Banana"))
            return new Fruit("Banana");
        else if(objectType.contentEquals("WaterMellon"))
            return new Fruit("WaterMellon");
        else if(objectType.contentEquals("SpecialBomb"))
            return new Bomb("SpecialBomb");

        return null;
    }
}
