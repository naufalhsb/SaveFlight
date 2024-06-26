import greenfoot.*;

public class BuffShield extends Actor
{
    public BuffShield()
    {
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }

    public void act()
    {
        checkCollision();
    }

    public void checkCollision()
    {
        if (isTouching(Plane.class))
        {
            Plane plane = (Plane) getOneIntersectingObject(Plane.class);
            plane.addShield();
            getWorld().removeObject(this);
        }
    }
}
