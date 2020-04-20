import java.util.HashMap;
import java.util.Map;

/**
 * @author zerodsLyn create on 2020/03/17
 */
public class Q1160_FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> char2Num = new HashMap<>(chars.length());
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (char2Num.containsKey(c)) {
                char2Num.put(c, char2Num.get(c) + 1);
            } else {
                char2Num.put(c, 1);
            }
        }

        int length = 0;
        for (String word : words) {
            length += handle(word, char2Num);
        }

        return length;
    }

    private int handle(String word, Map<Character, Integer> char2Num) {
        int[] char2NumArray = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            char2NumArray[c - 97] = char2NumArray[c - 97] + 1;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!char2Num.containsKey(c) || char2Num.get(c) < char2NumArray[c - 97]) {
                return 0;
            }
        }

        return word.length();
    }

    public static void main(String[] args) {
        System.out.println(new Q1160_FindWordsThatCanBeFormedByCharacters().countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(new Q1160_FindWordsThatCanBeFormedByCharacters().countCharacters(new String[]{"qobxtxjzdngkrzamsxzdvbvkiwijokwdyndqllhqpaoxzwonriclsm","fahtqqnuzhhhrcblquaosdfdcqoskxcsdnhtwvvvzsxkpjprytieieniafnltxmuzwkdnttofpibi","xedhntgrqegfs","wrssfvsbcehbahbvojnzgacbgveitirkjmmyiorwykynqddgydzgfvlvplfnyumgxturxraonpchd","hpmdzhpgijirecxzkuyhptiytnuscu","xljgysrjjukphjgzbpn","gmwbirxt","yhvpsvsnhfmbmcpihnqtodspbvexnpgcqrrughbakbufyjispkquvfppkaffypdpnvikjygdaarcigipfhuvzzzbgw","gvvbgpjolobpbxcnhnzuqrsqgrkanwmnnkqynakkooailoafunopsrlijqhaqmszssxikftcfoqsw","naktgxfyuvuoh","muui","ghzqskipqprrzeligdjyowypeerogxonvztsq","onosezgutawtzteoagbftclsqpfsxtwetourxjxurdqevrir","fcskqxwkzsldsjihahalnw","lsstgzxjxabcbspjwelqmhtnurgfmdtpaihxnxad","nwrwtwetgjwooevhxhkzlvsyghtkldioyjhkkniepktqs","utohzbqvkqkq","vdoqnhtidgicevprrrwlbtldtaxpsxdhxhgbwlkbeglkbhrujtafswjkozdmdpvwhsuskofmxxtprtpopacslinwozth","zqlzxpemomnbzxlorvlkxt","kubshvnldnkofitnnjere","czxmqpowzzhdbhgtlqdokrzxowsvwyavfhcycctgdvrsfzmanrlktfaetnuayrqkvhcbxezfahkrxgaaztovrxuhnll","rrcesnfbxglhjawldnnuiiepdsofbrsbjczlemusqwvenicxmtdmpwfrnizymfmqynvtkbrmablcugroshc","thholqebekkysstqzlbbdapktxumygplqganucwnahmrihiraxdnvbiaqhykcti","fagqnapzeeglbdzsbneosxmptmwopjcxztukhpjkqjmjbkpbzrfaqskctehyboeddmilkwlurcb","wtjdykncubkduhxiwwusoxvzpnaxpnzdjmwddnonsmmvwmuaxghetgrwpoeqbprxgviwzagyqopfdakrqjgiy","nsftehpgzstetbganbtozdopptseucdqkhzdmujnzjdvufqtikgeepttnrabb","ozihktgnvljzhqwanxemtzxphzqvmoblvi","iwdsrekqllbbyarzzmbqbvldvxctdeswiyahiwfoefhfsfwktdzaulnalewbusazjhcbtxjuck","dylhds","idnaddnzbodhjrpshhahnbbnrskruxszxeeyanumazvahktizectmmvjbhnhbrohsyqhrgq","scyzsykrwzuozmbrbenfiqpxchtpmcxepjiglaeionsmbwrzeidupayusczcooudpcgkgspbuyzcdfymsejucb","otpcfrhckxmnseayhwoyjjfkceaoznmmkikpdsuueyqmbsuelmhqnmdsjs","xoghnhpypfiibqrpgtyux","cxhpbcziptgandiwxtctdjpboiqwv","gyjosuhwgbqpcdsdqadopdqozjxpzwxbqaffnxaddhgrxmunpidvpnijxnbawshcznkmprpgkhvzxmzbaftedgtfgjhaisdnva","jlnxshfthqgzlnvjzztrnjswwsotpybxecyqhnfkbfwvmxpcs","mtddspmqwbnoiajpexsuhxogarduzsoammqqelh","sixkvxgnbalipwmkbcwpugpvolsvvlmaaeeobmoeogspbkbsskwjdqkite","xhsutriuynfrldjbhexhxjgcfwcujvwsqfiaqwvjnkjkswdpaynelhryrzfeqjhajezmolk","zfiredtxenzgtrkiamuoubetexzbnwkdtxbtihhtsfubnmryxq","sot","szgkkhuhkcnr","firxkgvkzqlnallzwjispsizoawobemuhqrhpyvknasjzwctamfuonder","vyei","fidqszoicndwifns","xkickycwzj","gmybflbjunudxrwguzditaxmyadgdjeengut","gvlwwnmrddhzwewugdtobauecealfhasyftgxkiqeluysxxmroukfziifpryvddggttojhcszeyjetbsldmorqnbuqreuxfw","vbhuerxkcjlkamgruturkbrubbscmvzqruwvlrlyylcvuiothkhpznjzsfnyfoaqkziyjqzdreeygmtbdljwnaojexfgmjlup","bxjvop","aswdmctosieicucsjwxych","lxbtlhnrfyaznrqgxrltmxkjmhdqjjgnvstxaygmuxznjfiiukm","npncdabkmbgfhnedcmbfyjiplzwymgvsfrifvvjayobsygwolqbwkblqutakcshnlsqadtfiqmpauslvqd","kuyemuuymacyvmahtagmcewkspverpjtjscccnrczchgkjzppdxcalxxcxrwnepk","jxwouobfvzttz","yucpsdhqvzboeezcqpxsepuuk","iwbdmxdcbypnzqmgkrjhfivkrmnv","lpqklgcwdvgbghfyoyejnpexrelywqfdtczflwetbxvzigtvisi","dlasodatffcreungntdmezgfqklrabyymsnhdberufcrgpxgsziklznhdprbczhbxgtuslufycjronozdqumzlnidkvaydg","oejzlmrrbdysqlezifcvgjnmvodfvmrnjmnfkejdbnnyljzjaxfecrfefdgarqbtwoijuktacywmsubtxtgzkbnstgrsrjpkdfe","mlegvhxielwlfadlnqvnipcuizpdxgtvro","vwgmwkbturocovaykdsjaftbtgmtwknnmhexfgcfchpwwgcgecfobbencotjizxbtdrijwfjxdsxanwfjyjamrxrdaiusgr","xjmkcsekcorldyrjiavrhuhqtndujymc","rmxwcaorznumwxgwnibnxwzvnxjhzwqzgmkgifnnnnzpgtsvprycjtdeirtpqbduursabbidzkfbexgthkoacagkb","tkrsxhztwgvqxamjtexklnooaloydjhejlbasavskttwxiabarogvmfdfjttaxhgqljlbfnrvrwwbxkurhufiknoxfmemcv","cojlyayladyrhofzetaddteqrjbyxtvyszgdorexqmgznqmuvemegbwki","zktqnurtpttlcjgkmnprqeyeepqunfqqvjwuevwbvnaupyofwiqwhpyumyfwpjrruhleromrmpvczlkxqiuq","gyxl","qmhwlymfsjixvvjhkczylqcsnbjxliasetxciggtfl","gizysqkqbyhzeagzsscvdigtcfiupyhqovaaioxfrphugxzrcjvwqwc","hpgkulrmbaixnjiapmjiwhwsgromfqpxqkkiscjwpiicslwcijginxfiwqakeezeohhskxgvgdkezmqys","vibswdyqaxjvqsffwmcismooheyhwzqvyzezluejztlgddshvwcryzcllaisxrygwqyyoiaivfvgtzicycyrkckv","oyclwdejlifmocfjsbgmernsyitkfaahjxfnwnusrdypsziawlpsjgnavytdihpxcmugshnqbkyfts","xwcbiporfbktpvqhznjuaxfcdykifuzwdsdhxirwwxinoffywgxscrtuwhvuwjejzqirsfijgguouapqpmfdnpsfm","qffrjfkj","rpynimubaxdgbrkdawgugnhobaowxdnzkiidworcsnejgqctftyksvbhiwkcnyffmsbxwptqn","oeqdvldvfbklukstxwomapaauaozblhxudkdxihepqagndnlkvbqhluscvczhrsrhodnftoszhjdymuywdtjgzbmkrdf","xviupppkeswkctwlqwyuhokbhqqjshmaeiouhununbhrkabacenkg","habomjnlznqvckmowgelhnglfizogckplbymkdowfpicxydzgoskckraxpdysksvzezcpg","zemawxwjeowraaqsqytsshtavnvoyiyollelxqabmjwhxtrdijiacbbjiiyzwkxboot","jcnpsxnkbqdbh","bftrbaurtzkftodotjguzjmwxrrmswxwclohotuanypmhtemmsaicwckowmcdmpnhcfzptekpgljfvwpqjgilxu","bbaigjqxdmuchkkb","effbptpwafzqbsebbjmvdcxdbmnlfqjklongafzkvaqmkehefedjxgxlbdhltihtgfqjjsdis","lhuxgqpwcgpujfvvnlrxhgbiwxmxzhglyhkdkafafojtlkuxkmjwlxrd","ussuyjqsxwsdhkjeipwycrkcxxjatoqhygzymgikqdnqiyyzlbcdlgtmneyickucbkpkza","ykmsksjorovmdymlbgprvprnyxwppvwgmzfjsqouvgara","wduqkbncayo","qdfkyomjlhfozonwpdxllqdnvpohyijqmyymuclnydzmlqksntdfj","ynzekkkljzrvnwclzcfgtvcmstxgadxpztofckypbgqgbnumnkeaqclaspzxjbygtkjznxeduhbksr","aw","jbremnahqoiqktpbkteefdkbrerrxmhqbbselpnfzapgmxidrhbixetaetjcroufa","wtufuqgljvxzsurhviikdxyuythezjnvwrxqrykmotkhlphlyfljjsfugzwxxfqkc","ytjuaagqnfxqwiopolnejmoxow","oqoskpzkwxsffgeuuhdklidtmjobzayatyaqefgwgqbo","qkhtpuhhkspffkpryvdjasbxhtfrmptpljszvtgvhfvqpxypxfdaphfqdmigzgfg","goddugelwdvemxwureitzwqmbqeqtymrlrzahuxnpgufaagbpexwpoahvdnsyvgxw","dfhxrctagxkuasofoejsalcerkbtsjwnbnoahsumzfyiiskhzzwyykeefszrzrbztbrzhxxgaajb","tjsardsbhmhefysdqtbhzsxukbwdpioqaohloaancxdkkmofniojrvxj","jzjozqfqiwyfadplibubtpcfxxfvjtbizxlmpaccjpihvnrtvfqtfiaztvfbednyemfmahbljdvykddawaujdksenm"},
                                                                                            "fcxpzkzkqeyeijquyfixvlzjpzomujrqzxeoynjiflnmdrpdkrm"));
        System.out.println(new Q1160_FindWordsThatCanBeFormedByCharacters().countCharacters(
                new String[]{"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
                        "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb",
                        "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
                        "boygirdlggnh",
                        "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
                        "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
                        "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
                        "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
                        "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","" +
                        "oxgaskztzroxuntiwlfyufddl",
                        "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
                        "qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv",
                        "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
                        "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
                        "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
                        "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo",
                        "teyygdmmyadppuopvqdodaczob",
                        "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
                        "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"
                }, "welldonehoneyr"));
    }
}
