import greenfoot.*;

public class MenuWorld extends World
{
    public MenuWorld()
    {
        super(600, 400, 1);
        prepare();
    }

    private void prepare()
    {
        addObject(new Button("Play"), getWidth() / 2, getHeight() / 2 - 50);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(null)) {
            Actor clickedActor = Greenfoot.getMouseInfo().getActor();
            if (clickedActor instanceof Button) {
                Button button = (Button) clickedActor;
                if (button.getText().equals("Play")) {
                    Greenfoot.setWorld(new MyWorld());
                }
            }
        }
    }
}
