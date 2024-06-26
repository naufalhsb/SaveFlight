import greenfoot.*;

public class Bird extends Actor
{
    public Bird()
    {
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }

    public void act()
    {
        moveLeft();
        checkIfOutOfBounds();
    }

    public void moveLeft()
    {
        setLocation(getX() - 3, getY());
    }

    public void checkIfOutOfBounds()
    {
        if (getX() <= 0) {
            getWorld().removeObject(this);
        }
    }

    public void checkCollision()
    {
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if (bullet != null)
        {
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            getWorld().removeObject(this);
            getWorld().removeObject(bullet);
        }
    }
}
