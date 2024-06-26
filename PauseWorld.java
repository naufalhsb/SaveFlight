import greenfoot.*;

public class PauseWorld extends World
{
    private World previousWorld;

    public PauseWorld(World previousWorld)
    {
        super(600, 400, 1);
        this.previousWorld = previousWorld;
        showText("Game Paused", getWidth() / 2, getHeight() / 2 - 50);

        // Menambahkan tombol Resume
        Button resumeButton = new Button("Resume");
        addObject(resumeButton, getWidth() / 2, getHeight() / 2);

        // Menambahkan tombol Back to Menu
        Button backButton = new Button("Back to Menu");
        addObject(backButton, getWidth() / 2, getHeight() / 2 + 50);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                Actor clickedActor = mouse.getActor();
                if (clickedActor instanceof Button) {
                    Button button = (Button) clickedActor;
                    if (button.getText().equals("Resume")) {
                        Greenfoot.setWorld(previousWorld);
                    } else if (button.getText().equals("Back to Menu")) {
                        Greenfoot.setWorld(new MenuWorld());
                    }
                }
            }
        }
    }
}
