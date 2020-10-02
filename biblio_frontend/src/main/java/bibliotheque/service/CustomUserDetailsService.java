package bibliotheque.service;

import bibliotheque.modele.Usager;
import bibliotheque.proxies.BibliothequeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final BibliothequeProxy bibliothequeProxy;

    @Autowired
    public CustomUserDetailsService(BibliothequeProxy bibliothequeProxy) {
        this.bibliothequeProxy = bibliothequeProxy;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usager usager= bibliothequeProxy.chercherUsagerParIdentifiant(username);
        if (usager == null){
            throw new UsernameNotFoundException(username + " non trouvé");
        }
        return usager;
    }

}
