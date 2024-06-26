import greenfoot.*;

public class Button extends Actor
{
    private String text;
    private int width;
    private int height;
    private Color textColor;
    private Color backgroundColor;

    public Button(String text)
    {
        this(text, 150, 50, Color.WHITE, new Color(0, 0, 139)); // Warna biru gelap
    }

    public Button(String text, int width, int height, Color textColor, Color backgroundColor)
    {
        this.text = text;
        this.width = width;
        this.height = height;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        updateImage();
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(backgroundColor);
        image.fillRect(0, 0, width, height);
        image.setColor(textColor);
        image.drawString(text, (width - text.length() * 7) / 2, height / 2 + 5);
        setImage(image);
    }

    public String getText()
    {
        return text;
    }
}
