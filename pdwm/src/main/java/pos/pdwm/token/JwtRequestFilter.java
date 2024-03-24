
// package pos.pdwm.token;

// import java.io.IOException;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.ExpiredJwtException;
// import io.jsonwebtoken.Jws;
// import io.jsonwebtoken.Jwts;
// import org.springframework.http.HttpHeaders;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import java.util.Collections;

// public class JwtRequestFilter extends OncePerRequestFilter {

//     @Value("${jwt.secret}")
//     private String jwtSecret;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//             throws ServletException, IOException {

//         final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

//         String username = null;
//         String jwt = null;

//         if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//             jwt = authorizationHeader.substring(7);
//             try {
//                 Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
//                 username = claims.getBody().getSubject();
//             } catch (ExpiredJwtException e) {
//                 // Token expirado
//             }
//         }

//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                     username, null, Collections.emptyList());

//             SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//         }

//         chain.doFilter(request, response);
//     }
// }