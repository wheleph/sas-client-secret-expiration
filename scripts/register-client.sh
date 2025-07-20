curl -X POST --location "http://localhost:8080/connect/register" \
    -H "Authorization: Bearer eyJraWQiOiI4YmRiMjcwMS1hMzk1LTQ3N2UtYTA3YS1mNzlkZTA5NWNkOWUiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJjbGllbnQiLCJhdWQiOiJjbGllbnQiLCJuYmYiOjE3NTMwMjgxOTMsInNjb3BlIjpbImNsaWVudC5jcmVhdGUiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwIiwiZXhwIjoxNzUzMDI4NDkzLCJpYXQiOjE3NTMwMjgxOTMsImp0aSI6IjdlZjFmODdiLWIxMmQtNDRjYi04MmQ2LWFlMzgyOTVmOTAzMSJ9.fuYVMXQgwLI1cAYOJW4zrbwx5GT0LARIuxLEAWXpg_4MUy5JsKx31GXtw-2xBx-Agmzduaxm8FZ2dXkFv513fE6Wu9u0NbLWJPW4AOV4Dd1dWu_s0Rtodtn5jEEEFqBf4A6gcY16Y709JLAoAp34-vUQHABE8gaKq6UtZvPvtRron3cAPqqdD7IqCmu59tVE8qHVisGNTeKK1s0u1OnQsOfbJZdBlVitm3qdehuCmhyj6SRNhW-DpWxI86eNbYNqilSewpuSsvpCex_VpnxEFBaVFW1nXm13pwZqQ4hH1Omzds-tuX3fu9OSe3CGoxNjX8wfPiaqb61ur9ox4voGpQ" \
    -H "Content-Type: application/json" \
    -d '{
          "redirect_uris": ["https://example.com"],
          "client_name": "test_dynamic_client",
          "grant_types": ["client_credentials"],
          "token_endpoint_auth_method": "client_secret_basic",
          "scope": "foo,bar"
        }'