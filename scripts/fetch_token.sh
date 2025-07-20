curl -X POST --location "http://localhost:8080/oauth2/token" \
    -H "Authorization: Basic Y2xpZW50OnNlY3JldA==" \
    -H "Content-Type: application/x-www-form-urlencoded" \
    -d 'grant_type=client_credentials&scope=client.create'