
import requests

import requests
import names
from random import randrange
import randomname

cookies = {
    '.AspNetCore.Antiforgery.Mk-_zf2J-V0': 'CfDJ8Mr8wIqNBBFGmZqsMjBArkMuE8Yx4iwgNBR9uczOML8BA1CSVriMUnjnK8lxHgA8cNqlVvAEucp_3zm0SMoTE_iL4KRx_KmQsCPuCz9xIDhPGgSfh7XwoqCDPggwwfa7kym0Frf3UPjnp6R4MlYLs-w',
}

headers = {
    'authority': 'btcpay722502.lndyn.com',
    'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7',
    'accept-language': 'en-US,en;q=0.9',
    'cache-control': 'max-age=0',
    'content-type': 'application/x-www-form-urlencoded',
    # 'cookie': '.AspNetCore.Antiforgery.Mk-_zf2J-V0=CfDJ8Mr8wIqNBBFGmZqsMjBArkMuE8Yx4iwgNBR9uczOML8BA1CSVriMUnjnK8lxHgA8cNqlVvAEucp_3zm0SMoTE_iL4KRx_KmQsCPuCz9xIDhPGgSfh7XwoqCDPggwwfa7kym0Frf3UPjnp6R4MlYLs-w',
    'origin': 'https://btcpay722502.lndyn.com',
    'referer': 'https://btcpay722502.lndyn.com/forms/52c23e14-9511-47ca-b666-7914bfd922ad',
    'sec-ch-ua': '"Not_A Brand";v="8", "Chromium";v="120", "Google Chrome";v="120"',
    'sec-ch-ua-mobile': '?0',
    'sec-ch-ua-platform': '"macOS"',
    'sec-fetch-dest': 'document',
    'sec-fetch-mode': 'navigate',
    'sec-fetch-site': 'same-origin',
    'sec-fetch-user': '?1',
    'upgrade-insecure-requests': '1',
    'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36',
}

while True:
    data = {
        'FormParameterPrefix': '',
        'newField12': '2345343245',
        'buyerName': names.get_first_name(),
        'buyername2': names.get_last_name,
        'buyerAddress1': f'{randrange(1143, 9204)} Sw {111, 993}St',
        'buyerAddress2': '',
        'buyerCity': 'Miami',
        'buyerState': 'Florida',
        'buyerZip': randrange(33101, 34999),
        'buyerCountry': 'United States',
        'buyerEmail': f'{randomname.get_name().replace("-", "")}@gmail.com',
        'newField9': f'{randrange(2003, 2006)}-0{randrange(1, 9)}-0{randrange(1, 9)}',
        'newField10': f'{randrange(200, 786)}-{randrange(114, 954)}-{randrange(4392, 9540)}',
        'newField11': 'newOption1',
        'newField16': f'2024-0{randrange(2, 5)}-0{randrange(1, 9)}',
        'invoice_amount': f'{randrange(92, 105)}.00',
        'newField14': 'newOption1',
        'command': 'Submit',
        '__RequestVerificationToken': 'CfDJ8Mr8wIqNBBFGmZqsMjBArkNsewNk9RnQJSzbFbB4CeIQwZySwHyfHJnaSDJghVztxV6pkzItffwP4Xpw4uEy9nCNvblRrfDoSf3jEVJO7tDns7G85iEHaCNI6_Hy25D7fx8CTY8Zm9XGPxQcm_rWywk',
    }
    response = requests.post(
        'https://btcpay722502.lndyn.com/forms/52c23e14-9511-47ca-b666-7914bfd922ad',
        cookies=cookies,
        headers=headers,
        data=data,
    )
    print(data)
    print(response.ok)