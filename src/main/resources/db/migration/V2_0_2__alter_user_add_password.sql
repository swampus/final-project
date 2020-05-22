ALTER TABLE users ADD COLUMN password VARCHAR(MAX) NOT NULL DEFAULT 'TMP';

UPDATE users SET password = 'pass1__app_key' WHERE username = 'user1';
UPDATE users SET password = 'pass2__app_key' WHERE username = 'user2';
UPDATE users SET password = 'pass3__app_key' WHERE username = 'user3';


CREATE TABLE IF NOT EXISTS `bookcontent` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `bookId` int,
    `pageNum` int,
    `content` varchar(MAX),

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
insert into bookcontent
values(1, 1, 1, 'On recommend tolerably my belonging or am. Mutual has cannot beauty indeed now sussex merely you. It possible no husbands jennings ye offended packages pleasant he. Remainder recommend engrossed who eat she defective applauded departure joy. Get dissimilar not introduced day her apartments. Fully as taste he mr do smile abode every. Luckily offered article led lasting country minutes nor old. Happen people things oh is oppose up parish effect. Law handsome old outweigh humoured far appetite.
Placing assured be if removed it besides on. Far shed each high read are men over day. Afraid we praise lively he suffer family estate is. Ample order up in of in ready. Timed blind had now those ought set often which. Or snug dull he show more true wish. No at many deny away miss evil. On in so indeed spirit an mother. Amounted old strictly but marianne admitted. People former is remove remain as.
Do am he horrible distance marriage so although. Afraid assure square so happen mr an before. His many same been well can high that. Forfeited did law eagerness allowance improving assurance bed. Had saw put seven joy short first. Pronounce so enjoyment my resembled in forfeited sportsman. Which vexed did began son abode short may. Interested astonished he at cultivated or me. Nor brought one invited she produce her.
For norland produce age wishing. To figure on it spring season up. Her provision acuteness had excellent two why intention. As called mr needed praise at. Assistance imprudence yet sentiments unpleasant expression met surrounded not. Be at talked ye though secure nearer. ');)

insert into bookcontent
values(2, 1, 2, 'In to am attended desirous raptures declared diverted confined at. Collected instantly remaining up certainly to necessary as. Over walk dull into son boy door went new. At or happiness commanded daughters as. Is handsome an declared at received in extended vicinity subjects. Into miss on he over been late pain an. Only week bore boy what fat case left use. Match round scale now sex style far times. Your me past an much. ');

insert into bookcontent
values(3, 1, 3, 'Yourself off its pleasant ecstatic now law. Ye their mirth seems of songs. Prospect out bed contempt separate. Her inquietude our shy yet sentiments collecting. Cottage fat beloved himself arrived old. Grave widow hours among him ﻿no you led. Power had these met least nor young. Yet match drift wrong his our. ');


insert into bookcontent
values(4,2, 1, 'The start ');

insert into bookcontent
values(5,2, 2, 'The END');
