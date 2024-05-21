import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bird extends Actor
{
    public Bird()
    {
        GreenfootImage image = getImage();
        image.scale(30, 30); // Sesuaikan ukuran 30x30 sesuai keinginan Anda
        setImage(image);
    }

    public void act()
    {
        moveLeft();
        checkIfOutOfBounds();
    }

    private void moveLeft()
    {
        setLocation(getX() - 3, getY());
    }

    private void checkIfOutOfBounds()
    {
        if (getX() == 0) {
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.removeObject(this);
        }
    }
}
