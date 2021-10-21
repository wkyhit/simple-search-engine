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
        3. after selecting the inquiry method, you will be asked to input a single keyword or phrase, based on your previous selection
        4. the console will return following information - total hits, top 10 results(in order) with scores and matching segments

Explanations of sample output:
    
    1. select single keyword query - input keyword "accessories"
    results are as follows:
        
        Query time consuming: 160ms

        total hits: 16257

        score: 11.548266
        docId: 674037
        content: 
        So glad NORTHWEST Auto Accessories moved to bigger location! They have everything for truck accessories also Thule racks, tires for trucks fancy accessories for trucks.

        score: 11.186857
        docId: 338259
        content: 
        I like the store. They have some interesting clothes I mainly like the accessories. The sizing is weird I'm not sure where their size chart came from. Which is why I like to stick to their accessories. They have a ton of nice accessories so I can dress up any outfit.  They also have unique hair accessories, I purchase the largest hair bun filler thing I've ever seen there. There aren't many cashiers there so the lines are always long.

        score: 11.152577
        docId: 3736006
        content: 
        Accessory department continues to just suck... simple question ... what is the largest tires and rims I can put on my truck without additional lift kit... accessory department says we don't do that ??? I call bs and inform the accessory person that you a person on staff and that's all they do ...

        score: 11.01431
        docId: 3892153
        content: 
        This place is a small gem.  Friendly owner.  Beautiful clothes, accessories, very interesting little home/accessories/antiques.  And great prices for the highly-edited items.  Thanks!

        score: 11.01431
        docId: 6036093
        content: 
        Bought my first AR here and a bunch of accessories. Super helpful and informed staff. Will continue to go back here for my firearms and accessories.

        score: 10.979479
        docId: 5434607
        content: 
        Got the 10% off accessory coupon for checking in, spent 150$ on accessories and they wouldn't take the coupon even after the manager came to check it out.

        score: 10.925384
        docId: 8001608
        content: 
        Having just received a Big Green Egg as a (generous) gift from a family member, I went to the BBQ Barn to stock up on accessories. The extremely helpful salesperson identified the accessories that made sense for a beginner...and actually talked me out of buying several additional accessories, suggesting I spend time using the BGE before spending money on accessories I may not need.
        This is simply the best place for smokers, grills, related accessories, and expert advice on how to use them.

        score: 10.89931
        docId: 4406506
        content: 
        Tired of going to the malls on the hunt for accessories? Tired getting trapped in Claires or Icing with all the "Teeny Boppers"? Tired of going in your favorite clothing stores, finding the perfect outfit, but scrapping through their limited selection of accessories? Well I found the answer and its in Atlanta's own Atlantic Station. Its a small accessory stored called Pink Heart. Pink Heart is located right next to H&M at in Atlantic Station. The best way I can describe this place is "Claire's for 21 and up!" There are tons of great-looking costume jewelry, purses, and other accessories. But the clear for front of the store are the top to bottom walls of attractive accessories, in every color you need, at great prices There is usually only one person working in the shop. But I doubt you will need any help finding anything because its all laid in front of you, arranged by type of accessory, grouped in color blocks, and arranged with smallest accessory being at the top of the wall progressing to larger accessories toward the bottom. The is an awesome place to get  some really affordable statement pieces as well. There is truely something for everybody here! Its wonderful, TRUST ME!! I give Pink Heart an C for decor, its pretty average. They pretty much let the accessories decorate the store, which isn't a bad thing. I give Pink Heart an A for Customer Experience because the selection is AWESOME!! Its so organized and so easy to shop here. I seriously doubt you could be let down when you come to this place.

        score: 10.842327
        docId: 6897691
        content: 
        I come here almost daily for vape accessories and e liquid. The people who work here are super friendly and awesome. They also have great prices for other smoke accessories too.

        score: 10.783105
        docId: 693946
        content: 
        Absolutely love the store. Went to get some new accessories for a very old radio, and they had everything I needed at a fair price.
        The staff are very knowledgeable and can help in selecting books, radios and other accessories.
        The in-store experience is much better than the online catalog because the staff can demonstrate features for you, and make sure you are purchasing the proper accessory.


    2. select phrase query - input phrase "take care of"
    result are as follows:
        Query time consuming: 94ms

        total hits: 47772

        score: 9.827278
        docId: 5599294
        content: 
        Excellent service! Non-pushy mechanics who want to take care of you, and take care of the environment. Top notch stuff!

        score: 9.795701
        docId: 5172397
        content: 
        Mark and Kevin ALWAYS take care of me quickly as well as efficiently. They always make time to take care of me!

        score: 9.640813
        docId: 4568345
        content: 
        If you can't take care of a costumer let them know instead of taking in costumers you can't take care of.

        score: 9.627861
        docId: 3482327
        content: 
        Do Not come to this store! There are 4 employees and only 2 are taking care of customers, the other two are wandering around like if the were a show phone... there is not a sense or urgency to take care of customers. I been here for over an hour and they all disappeared only one is taking care of customers... what a shame

        score: 9.627861
        docId: 3987242
        content: 
        There is a blurry line between FASHION and FRUMP.  This place stands clearly on the side of frump.
        An author once said, "take care of beauty, and truth will take care of itself."  I feel mean for having written the words in the previous paragraph, but what can an honest girl do?   Mint Julep fails miserably at taking care of beauty.

        score: 9.627861
        docId: 4158429
        content: 
        Bill and co. always take care of my and my vehicle.  I have 100% trust and confidence in their skills and honesty.  I haven't felt so safe with a mechanic's care since my uncle (mechanic of 40 years) taking care of my car as a young driver.  Very fair.  Quick turn around.  No nonsense.  Takes care of the whole family.

        score: 9.627861
        docId: 6176069
        content: 
        I'm a huge believer in the owner and main man taking care of the company.  
        You take care of your people and they take care of you!!

        score: 9.580219
        docId: 3181865
        content: 
        Owners always take care of me and every person I recommended they take care of too!
        
        score: 9.550208
        docId: 3619140
        content: 
        Great friendly person. Helped me understand how to take care of my hair. Got my locs started and told me how to take care of them. Enjoyed the whole experience!

        score: 9.547454
        docId: 2408396
        content: 
        Shout Out To Justin!! BIG THANK YOU FOR TAKING CARE OF US!! After flying all night, ruff travel and a wrong booking location he was able to still take care of us. 
        May God bless you and take care of you as you have taken care of us. Amen!!

                    
                            