package explorer;

import java.io.File;

public class InnerExplorer {
		private static File mainRoute;
		private static String baseRoute = "C:\\UserArchives\\";
		
		
		public static void main(String[] args) {
			File userRoute = getMainRoute("usuario3");
			System.out.println(userRoute);
			for(String n : userRoute.list()) {
				System.out.println(n);
			}
			
		}
		
		public static File getMainRoute(String username) {
			mainRoute = new File(baseRoute+"\\"+username);
			
			if(!mainRoute.exists()) {
				if(mainRoute.mkdir()) {
					System.out.println("Creado");
				}else {
					System.out.println("ERROR");
				}
			}
			return mainRoute;
		}
		
}
