package com.assetco.hotspots.optimization;

import com.assetco.search.results.Asset;
import com.assetco.search.results.AssetVendor;
import com.assetco.search.results.AssetVendorRelationshipLevel;
import com.assetco.search.results.HotspotKey;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.assetco.search.results.AssetVendorRelationshipLevel.Partner;
import static com.assetco.search.results.HotspotKey.Showcase;


public class BugsTest {
    @Test
    void precedingPartnerWithLongTrailingAssetsDoesNotWin() {
        AssetVendor partnerVendor = givenVendor(Partner);
        Asset missing = givenAssetInResultsWithVendor(partnerVendor);
        List<Asset> expected = givenSufficentAssetsInResultsToTriggerShowcase(partnerVendor);

        AssetVendor secondPartnerVendor = givenVendor(Partner);
        givenAssetInResultsWithVendor(secondPartnerVendor);

        whenOptimize();

        thenHotspotDoesNotHave(Showcase, missing);
        thenHotspotHasExactly(Showcase, expected);
    }

    private AssetVendor givenVendor(AssetVendorRelationshipLevel level) {
        return makeVendor(level);
    }

    private AssetVendor makeVendor(AssetVendorRelationshipLevel level) {
        return null;
    }

    private Asset givenAssetInResultsWithVendor(AssetVendor vendor) {
        return null;
    }

    private List<Asset> givenSufficentAssetsInResultsToTriggerShowcase(AssetVendor vendor) {
        return Arrays.asList(
            givenAssetInResultsWithVendor(vendor),
            givenAssetInResultsWithVendor(vendor),
            givenAssetInResultsWithVendor(vendor),
            givenAssetInResultsWithVendor(vendor)
        );
    }

    private void whenOptimize() {
    }

    private void thenHotspotDoesNotHave(HotspotKey hotspotKey, Asset... assets) {
    }

    private void thenHotspotHasExactly(HotspotKey showcase, List<Asset> expected) {
    }
}
