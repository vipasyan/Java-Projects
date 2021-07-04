import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Check {

	public static void main(String[] args) {
	
		  
		        // Security.addProvider(new
		        // org.bouncycastle.jce.provider.BouncyCastleProvider());
		 
		        // get a list of services and their respective providers.
		        final Map<String, List<Provider>> services = new TreeMap<>();
		 
		        for (Provider provider : Security.getProviders()) {
		            for (Provider.Service service : provider.getServices()) {
		                if (services.containsKey(service.getType())) {
		                    final List<Provider> providers = services.get(service
		                            .getType());
		                    if (!providers.contains(provider)) {
		                        providers.add(provider);
		                    }
		                } else {
		                    final List<Provider> providers = new ArrayList<>();
		                    providers.add(provider);
		                    services.put(service.getType(), providers);
		                }
		            }
		        }
		 
		        // now get a list of algorithms and their respective providers
		        for (String type : services.keySet()) {
		            final Map<String, List<Provider>> algs = new TreeMap<>();
		            for (Provider provider : Security.getProviders()) {
		                for (Provider.Service service : provider.getServices()) {
		                    if (service.getType().equals(type)) {
		                        final String algorithm = service.getAlgorithm();
		                        if (algs.containsKey(algorithm)) {
		                            final List<Provider> providers = algs
		                                    .get(algorithm);
		                            if (!providers.contains(provider)) {
		                                providers.add(provider);
		                            }
		                        } else {
		                            final List<Provider> providers = new ArrayList<>();
		                            providers.add(provider);
		                            algs.put(algorithm, providers);
		                        }
		                    }
		                }
		            }
		 
		            // write the results to standard out.
		            System.out.printf("%20s : %s\n", "", type);
		            for (String algorithm : algs.keySet()) {
		                System.out.printf("%-20s : %s\n", algorithm,
		                        Arrays.toString(algs.get(algorithm).toArray()));
		            }
		            System.out.println();
		        }
		    }
		
}
	