class index
{
    //storing character in ch variable of type character
    Character ch;
    //storing frequency in freq variable of type int
    Integer freq;
    //initially both child (left and right) are null
    index left = null;
    index right = null;
    //creating a constructor of the Node class
    index(Character ch, Integer freq)
    {
        this.ch = ch;
        this.freq = freq;
    }
    //creating a constructor of the Node class
    public index(Character ch, Integer freq, index left, index right)
    {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}
