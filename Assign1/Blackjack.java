import java.util.*;

public class Blackjack
{
    static  boolean  checkRound  = true; //用于debug的时候 判断round是否小于等于10，是就显示details
    static int playerWins = 0;
    static int dealerWins = 0;
    static int push = 0;

    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in); //接收输入的两个int一个是round一个是牌堆牌的副数
        int desiredRounds = kbd.nextInt();
        int desiredDecks = kbd.nextInt();
        int deck = 0;
        int round = 0;
        final int NUMBER_OF_A_DECK = 52;

        RandIndexQueue<Card> shoe = new RandIndexQueue<Card>(desiredDecks * NUMBER_OF_A_DECK); //将RandIndexQueue的大小设置为刚好
        RandIndexQueue<Card> discard = new RandIndexQueue<Card>();
        RandIndexQueue<Card> player = new RandIndexQueue<Card>();
        RandIndexQueue<Card> dealer = new RandIndexQueue<Card>();

        if (desiredRounds <= 10) //如果输入的个数小于等于10 就要将checkRound变为false，用于debug输出细节
            checkRound = false;

        while (deck < desiredDecks) //将shoe里面所有的Card初始化
        {
            for (Card.Suits s : Card.Suits.values())
            {
                for (Card.Ranks r : Card.Ranks.values())
                    shoe.offer(new Card(s, r));
            }
           deck++;
        }

        System.out.println("Starting Blackjack with "+ desiredRounds
        + " and " + desiredDecks + " decks in the shoe");
        System.out.println();

        while (round < desiredRounds)
        {
            shoe.shuffle();
            debug("Round " + round + " beginning");

            initialCards(player, dealer, shoe);

            if (getValue(player) == 21 && getValue(dealer) == 21) //check blackjack
            {
                debug("Result: Push!");
                push++;
            }
            else if (getValue(player) == 21)
            {
                debug("Result: Player Blackjack wins!");
                playerWins++;
            }
            else if (getValue(dealer) == 21)
            {
                debug("Result: Dealer Blackjack wins!");
                dealerWins++;
            }//end blackjack

            else if (getValue(player) >= 17 && getValue(dealer) >= 17) //begins comparison
            {
                getResult(player,dealer);
            }//end comparison
            else //begins hits
            {
                while (getValue(player) < 17) //如果初始两张手牌点数大小小于17，就要摸牌，知道大于等于17
                {
                    debug("Player hits: " + shoe.peek());
                    player.offer(shoe.poll());
                }
                if (getValue(player) > 21) //一旦大于21就bust
                {
                    debug("Player BUSTS: " + player.toString() + " : " + getValue(player));
                    debug("Result: Dealer wins!");
                    dealerWins++;
                }
                else //如果没有bust就stand，看dealer是否需要摸牌
                {
                    debug("Player STANDS: " + player.toString() + " : " + getValue(player));
                    while (getValue(dealer) < 17)
                    {
                        debug("Dealer hits: " + shoe.peek());
                        dealer.offer(shoe.poll());
                    }
                    if (getValue(dealer) > 21)
                    {
                        debug("Dealer BUSTS: " + dealer.toString() + " : " + getValue(dealer));
                        debug("Result: Player wins!");
                        playerWins++;
                    }
                    else
                    {
                        debug("Dealer STANDS: " + dealer.toString() + " : " + getValue(dealer));
                        getResult(player, dealer); //两个人都stand 比较点数大小
                    }
                }
            } //end hits

            while (!player.isEmpty()) //把手牌弃到弃牌堆里
                discard.offer(player.poll());
            while (!dealer.isEmpty())
                discard.offer(dealer.poll());

            player.clear(); //clear两个数组
            dealer.clear();
            if (shoe.size() <= ((desiredDecks * NUMBER_OF_A_DECK) / 4)) //当当前牌堆里牌的个数小于等于原个数的四分之一，就把弃牌堆里的card放到shoe里面
            {
                while (!discard.isEmpty())
                    shoe.offer(discard.poll());
                System.out.println("Reshuffling the shoe in round " + round);
                System.out.println();
                shoe.shuffle(); //弃牌堆里面的card放完后洗牌
            }
            debug("");
            round++;

        }

        System.out.println("After " + desiredRounds + " rounds, here are the results:");
        System.out.println("\t \t Dealer Wins: " + dealerWins);
        System.out.println("\t \t Player Wins: " + playerWins);
        System.out.println("\t \t Pushes: " + push);

    }

    private static void debug(String text) //当round小于等于10的时候才print细节
    {
        if (!checkRound)
            System.out.println(text);
    }

    private static void initialCards(RandIndexQueue<Card> player, RandIndexQueue<Card> dealer, RandIndexQueue<Card> shoe)
    {
        player.offer(shoe.poll()); //player的初始手牌
        player.offer(shoe.poll());
        debug("Player: " + player.toString() + " : " + getValue(player));

        dealer.offer(shoe.poll());  //dealer的初始手牌
        dealer.offer(shoe.poll());
        debug("Dealer: " + dealer.toString() + " : " + getValue(dealer));
    }

    private static int getValue(RandIndexQueue<Card> player) //计算当前手牌的点数
    {
        int totalValue = 0;
        int nowValue = 0;
        int nowValue2 = 0;
        for (int i = 0; i < player.size(); i++)
        {
            nowValue = player.get(i).value();
            nowValue2 = player.get(i).value2();
            if (nowValue == 11 )
            {
                if ((totalValue + nowValue) > 21 )
                    totalValue += nowValue2;
                else
                    totalValue += nowValue;
            }
            else
                totalValue += nowValue;
        }
        return totalValue;
    }

    private static void getResult(RandIndexQueue<Card> player, RandIndexQueue<Card> dealer) //比较点数出结果
    {
        if (getValue(player) > getValue(dealer))
        {
            debug("Result: Player wins!");
            playerWins++;
        }
        else if (getValue(player) == getValue(dealer))
        {
            debug("Result: Push!");
            push++;
        }
        else if (getValue(player) < getValue(dealer))
        {
            debug("Result: Dealer wins!");
            dealerWins++;
        }
    }
}
