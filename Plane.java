import greenfoot.*;

public class Plane extends Actor
{
    private int fireRate = 20;
    private int fireCounter = 0;
    private int shieldStrength = 0;
    private GreenfootImage image;

    public Plane()
    {
        image = getImage();
        image.scale(100, 100);
        setImage(image);
    }

    public void act()
    {
        checkKeyPress();
        fire();
        checkCollision();
    }

    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 5);
        }
        if (Greenfoot.isKeyDown("right")) {
            moveRight();
        }
        if (Greenfoot.isKeyDown("left")) {
            moveLeft();
        }
    }

    private void moveRight()
    {
        setLocation(getX() + 3, getY());
    }

    private void moveLeft()
    {
        setLocation(getX() - 3, getY());
    }

    private void fire()
    {
        if (fireCounter >= fireRate)
        {
            if (Greenfoot.isKeyDown("space"))
            {
                Bullet bullet = new Bullet();
                getWorld().addObject(bullet, getX() + 50, getY()); // Menambahkan Bullet dengan offset 50 piksel ke kanan dari Plane
                fireCounter = 0;
            }
        }
        else
        {
            fireCounter++;
        }
    }


    private void checkCollision()
    {
        if (isTouching(Bird.class) || isTouching(StrongerBird.class)) {
            if (shieldStrength > 0) {
                shieldStrength--;
                removeTouching(Bird.class);
                removeTouching(StrongerBird.class);
            } else {
                MyWorld world = (MyWorld) getWorld();
                world.decreaseHealth();
                removeTouching(Bird.class);
                removeTouching(StrongerBird.class);
            }
        }
    }

    public void addShield()
    {
        shieldStrength = 3;
        GreenfootImage shieldedImage = new GreenfootImage(image);
        shieldedImage.setColor(Color.YELLOW);
        shieldedImage.drawOval(0, 0, shieldedImage.getWidth(), shieldedImage.getHeight());
        setImage(shieldedImage);
    }
}
