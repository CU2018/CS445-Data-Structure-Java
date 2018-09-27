public class MyDataStructure<T>
{
    private T[] array;

    public MyDataStructure()
    {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public MyDataStructure(int desiredCapacity)
    {
        array = (T[]) (new Object[desiredCapacity]);
    }
}
