#!python
def tag(tag, *args, **kwargs):
    if 'html_class' in kwargs:
        kwargs['class'] = kwargs.pop('html_class')

    propriedades = ' '.join(
        (f'{prop}="{value}"'for prop, value in kwargs.items()))
    conteudo = ''.join(args)
    return f'<{tag} {propriedades}>{conteudo}</{tag}>'


if __name__ == '__main__':
    print(
        tag('p',
            tag('span', 'Curso de Python 3, por '),
            tag('strong', 'Juracy Filho', id='jf'),
            tag('span', ' e '),
            tag('strong', 'Leonardo Leitão', id='ll'),
            tag('span', '.'),
            html_class='alert'
            )
    )
