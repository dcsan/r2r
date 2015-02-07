YOUR_API_KEY=keyZxed55akTIHEbA

# curl https://api.airtable.com/v0/app17f4cc2c975940/foo?api_key=$YOUR_API_KEY

curl "https://api.airtable.com/v0/app17f4cc2c975940/grammar?limit=20" \
-H "Authorization: Bearer $YOUR_API_KEY"
