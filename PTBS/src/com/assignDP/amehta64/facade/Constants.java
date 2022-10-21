package com.assignDP.amehta64.facade;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constants {
    public static Path currentRelativePath = Paths.get("");

    public static String rootPath = currentRelativePath.toAbsolutePath().toString();

    public static  String dbPackagePath = "/src/com/assignDP/amehta64/db/";

    public static String filePath = rootPath + dbPackagePath;

    public static String BuyerInfo = "BuyerInfo.txt";

    public static String SellerInfo = "SellerInfo.txt";

    public static String ProductInfo = "ProductInfo.txt";

    public static String UserProduct = "UserProduct.txt";

}
