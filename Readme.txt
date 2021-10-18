third part libraries:
    fastjson-1.27: https://mvnrepository.com/artifact/com.alibaba/fastjson/1.2.7
    lucene-7.73: https://lucene.apache.org/core/downloads.html

guide:
    installation step: 
        1. open the CreateIndex.java
        2. config the DATA_DIR and INDEX_DIR. DATA_DIR is the path of the review.json, and INDEX_DIR is the path of the index directory.
        3. run the CreateIndex.jave
        4. open the SearchIndex.java and config the INDEX_DIR path.
    user tutorial:
        1. run the searchEngine.java
        2. first you need to select the inquiry method. Input number 0 - single keyword query; Input number 1 - phrase query; Input others - exit
        3. after selecting the inquiry method, you will asked to input a single keyword or phrase, based on your previous selection
        4. the console will return following information - total hits, top 10 results(in order) with scores and matching segments

Explanations of sample output:
    
    1. select single keyword query - input keyword "prosciutto"
    results are as follows:
        total hits: 17108

        score: 11.620078
        docId: 3432812
        content: 
        Great crust, but missed the mark with toppings. Got the prosciutto fig pizza that must have had an entire jar of fig jam on top - made it pretty much inedible. And the prosciutto was more like tough overcooked ham (prosciutto cotto). Would have been so much better if it was prosciutto crudo.

        score: 11.556878
        docId: 127684
        content: 
        Be sure to get something with prosciutto in it! Their stuff with prosciutto is beyond amazing. My favorite is the appetizer that is crostini with fig jam and you guessed it...prosciutto!

        score: 11.378674
        docId: 3865839
        content: 
        Went back for the prosciutto with mozz. Good prosciutto and ingredients and I like the large variety of chips available. Will try a couple other sandwiches as well but prosciutto is always a go-to option in my book.

        score: 11.167869
        docId: 7163505
        content: 
        Had the fettuccini panna e prosciutto and cesare salad. Unfortunately, the meal was rather disappointing. The "prosciutto" came in cubed Italian ham form. Perhaps that was my mistake in assuming it would be cured, but is cured prosciutto not what people mean when they say prosciutto? That aside, while the portions were gigantic, the pasta was too salty overall. 
        It seems that this place is better known for their pizzas. I would agree based on my pasta experience.

        score: 11.136739
        docId: 284812
        content: 
        Ordered a prosciutto sub to go. Sat down at the Pru and no prosciutto - just mozzarella and tomato. F minus.

        score: 11.130112
        docId: 2413528
        content: 
        Not good.  I went in looking for a prosciutto sub, which is on their menu.  It took them about five minutes to locate prosciutto (it is at this point that I should have pulled the rip cord).  When they located prosciutto in their fridge, they had to slice the prosciutto, which had me thinking "hey, maybe this is good because it's fresh".  Wrong.  The issues only compounded from here.
        The prosciutto was thick sliced (prosciutto is traditionally thin sliced).  Their mozzarella was in processed flat sheets, instead of fresh mozzarella balls.   They asked me if I wanted mayonnaise and mustard on the sub (it's the equivalent of getting mayo/mustard on an Italian sub).  I asked for oil and vinegar, instead they used what I believe to have been Italian dressing.
        All around bad experience.

        score: 11.109479
        docId: 3693100
        content: 
        They don't just make sandwiches, they make the best prosciutto caprese sandwich I've ever had. Loaded with fresh prosciutto, creamy mozzarella and basil, this sandwich gives a new meaning to my usually boring lunch. Who cares you get prosciutto stuck between your teeth, this is definitely worth it!

        score: 11.061897
        docId: 890476
        content: 
        I ordered a green pizza with extra prosciutto. They told me the prosciutto will be raw slices on top which is what I wanted. But they actually added the prosciutto before going into the oven, which makes the pizza completely different, not in a good way. For a pizzeria, this is very unprofessional.

        score: 11.029729
        docId: 137868
        content: 
        Both pasta dishes we ordered were super salty.  The prosciutto pizza was generously spread with prosciutto but it made it taste salty also.

        score: 11.029729
        docId: 1704785
        content: 
        I ordered the prosciutto and fig panini and the prosciutto tasted spoiled and like bad ham. Temptations wasn't very tempting after all.
    
    2. select phrase query - input phrase "bicycle accessories"
    result are as follows:
        total hits: 5

        score: 16.065886
        docId: 7077538
        content: 
        So I needed to change my back bicycle tire. I searched on my Yelp app and found this place. I called and received great customer (phone) service. I stopped by and my bike was literally done in like 5 minutes. 
        Its a pretty cute shop with cool bicycle accessories. AND I got 10% off for checking in on Yelp. WIN WIN!!! If I ever need anything done on my bike I will definitely go to this location!

        score: 15.28684
        docId: 6637300
        content: 
        This is a really cute store with lots of stylish environmentally friendly products, from bowls made from old LPs to paper made from elephant poop (seriously). The store carries housewares (cups, dishes, candles), bags, bicycling accessories, jewelry, baby clothes, note cards. Perfect for last-minute gift buying.  Every item seems hand-selected and good-quality and the store is well laid out and organized. The prices aren't bad either. They also have a box where you can drop small electronics (cell phones, batteries) for free recycling.

        score: 15.04368
        docId: 450315
        content: 
        I am definitely a fan of Sports Authority.  This particular location has a good check in deal.  We came here near Christmas time to buy some presents and we had a good experience.  The staff members were very friendly and they helped us find what we were looking for.  We got some golf stuff, two pairs of shoes, a tennis racket bag, and some bicycle accessories.  The store was clean and well organized.  They have everything from apparel to basketballs and everything in between.  Good spot to buy athletic merchandise.

        score: 10.408107
        docId: 4318476
        content: 
        You want proof that Portland is awesome? Just visit Made Here PDX. This incredibly well-curated retailer represents a cross section of Portland-area artisans, selling everything from jams to surfboards. I was particularly smitten with collection of glass vases, the leather bicycle accessories and a completely badass double-headed axe. Also, I have a thing for concert posters, and the collection is definitely impressive.
        While it's not necessarily a negative, it does need to be at least pointed out that this store is pretty dang expensive. Of course, high quality artisanal products aren't going to be cheap, so you certainly get what you pay for. The price point would probably too high for some people, but if you have the cash to spend, this would be a fantastic place to buy a special gift. 
        There's a bit of a misconception that Made Here PDX is a holiday pop-up, but today I was excited to learn that they are in fact here to stay! With a location directly across 10th from Powell Books and right off a streetcar stop, they're poised to  benefit from quite a bit of tourist traffic. I have faith that they'll be around for quite some time, showing off the best of local products.

        score: 8.849826
        docId: 1385232
        content: 
        Coming to ride is a nice break from the typical chain coffee houses.  It is also a lot of fun if you happen to like to ride a bicycle.  (You don't need to ride a bicycle to go.)
        You come here to sit down and savor your drink.  This is not the place to stop, order a fast drink, wait for your name to be called, and leave with a drink in a paper cup.  Instead, this is where you go to come in, relax with some people, order from the counter and wait as your custom drink is delivered to you.
        I really like the vibe.  A few old wooden tables with chairs in the middle.  (Perhaps not enough for a big group.)  Lots of wooden beams are visible.  The first thing you see on the right are a few bicycles and bicycle accessories.  Not too many.  In any other place it would be filled with coffee paraphernalia.  Here it is riding gloves, lights, etc.
        Two of us came in on this cold day during a miserable, snowy February.  We ordered an Espresso and a cuppa Earl Grey.  The drinks were made carefully and delivered at the right temperature.  (Starbucks is too hot.)  And, yeah, in a ceramic cup.
        My friend and I chatted for an hour or so.  We never felt rushed.  Nobody was wandering around looking for a table.  Nothing like that.
        I would say that it was a completely enjoyable experience and a lot better than the bunch of shops -- Starbucks, Pete's, etc. -- that are also in Lexington.

            
                    