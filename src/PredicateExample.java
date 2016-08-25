import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Asset {
    public enum AssetType { STOCK, BOND };

    public final AssetType type;
    public final int value;

    public Asset(AssetType assetType, int assetValue) {
        type = assetType;
        value = assetValue;
    }
}
public class PredicateExample {
    public static void totalAssets(List<Asset> assets, Predicate<Asset> selector) {

        int total = 0;
        for(Asset ass : assets){
            if(selector.test(ass)){
                total += ass.value;
            }
        }

        System.out.println(total);

        System.out.println(
                assets.stream()
                        .filter(selector)
                        .findFirst()
                        .orElse(new Asset(Asset.AssetType.STOCK, 100)));
    }

    public static void main(String[] args) {
        List<Asset> assets = Arrays.asList(
                new Asset(Asset.AssetType.STOCK, 100),
                new Asset(Asset.AssetType.BOND, 200),
                new Asset(Asset.AssetType.STOCK, 300),
                new Asset(Asset.AssetType.BOND, 400)
        );


        //We don't want to go this route.
        //totalAssets(assets);
        //totalStockAssets(assets);
        //totalBondAssets(assets);

        totalAssets(assets, asset -> true);
        totalAssets(assets, asset -> asset.type == Asset.AssetType.STOCK);
        totalAssets(assets, asset -> asset.type == Asset.AssetType.BOND);
    }
}
