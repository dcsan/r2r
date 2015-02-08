# set -x

YOUR_API_KEY=keyZxed55akTIHEbA

# curl https://api.airtable.com/v0/app17f4cc2c975940/foo?api_key=$YOUR_API_KEY

curl "https://api.airtable.com/v0/app9Iu6T0gw5VfROa/topics?limit=3" \
-H "Authorization: Bearer $YOUR_API_KEY"
