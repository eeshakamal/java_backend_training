package test;

class Vehicles
{
    void type()
    {
        System.out.println("This is a vehicle");
    }
}
class Cars extends Vehicles
{
}
class Bikes extends Vehicles
{
}
class ToyVehicles extends Vehicles   // Not expected but still allowed
{
}
public class WithoutSealed
{
    public static void main(String[] args)
    {
        Cars c = new Cars();
        c.type();
        ToyVehicles t = new ToyVehicles();
        t.type();
    }
}

