import greenfoot.*;

public class StrongerBird extends Actor
{
    private int health = 3;

    public StrongerBird()
    {
        GreenfootImage image = getImage();
        image.scale(45, 45);
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
            health--;
            getWorld().removeObject(bullet);
            if (health <= 0)
            {
                MyWorld world = (MyWorld) getWorld();
                world.increaseScore();
                world.addObject(new BuffShield(), getX(), getY());
                getWorld().removeObject(this);
            }
        }
    }
}
