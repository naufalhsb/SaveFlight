import greenfoot.*;

public class Bullet extends Actor
{
    private int speed = 5;

    public Bullet()
    {
        GreenfootImage image = getImage();
        image.scale(10, 10);
        setImage(image);
    }

    public void act()
    {
        move();
        checkCollision();
    }

    public void move()
    {
        setLocation(getX() + speed, getY());
    }

    public void checkCollision()
    {
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
        else
        {
            Actor bird = getOneIntersectingObject(Bird.class);
            Actor strongerBird = getOneIntersectingObject(StrongerBird.class);
            if (bird != null)
            {
                MyWorld world = (MyWorld) getWorld();
                world.increaseScore();
                getWorld().removeObject(bird);
                if (getWorld() != null) {
                    getWorld().removeObject(this); // Hanya hapus Bullet jika masih ada di dunia
                }
            }
            else if (strongerBird != null)
            {
                StrongerBird sb = (StrongerBird) strongerBird;
                sb.checkCollision();
                if (sb.getWorld() == null) {
                    getWorld().removeObject(this); // Hanya hapus Bullet jika strongerBird sudah dihapus
                }
            }
        }
    }
}
